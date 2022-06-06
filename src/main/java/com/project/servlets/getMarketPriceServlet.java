package com.project.servlets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dao.UserDao;
import com.project.entities.Stocks;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@WebServlet(name = "getMarketPriceServlet", value = "/getMarketPriceServlet")
public class getMarketPriceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //get a logic to sell the stock at market Price
        try (PrintWriter out = response.getWriter()) {
            String stockId = request.getParameter("id");
            Stocks stocks = new UserDao(FactoryProvider.getFactory()).getStockById(stockId);
            if(stocks != null){
                String Symbol = stocks.getSymbol();
                String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" +Symbol + "&apikey=DSG6OJ6OOJ3WQ2BS";
                //get json data from url
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                int responseCode = con.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder res = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        res.append(inputLine);
                    }
                    in.close();
//                Gson gson = new Gson();
                    HttpSession session = request.getSession();
                    ObjectMapper objectMapper = new ObjectMapper();
                    res.deleteCharAt(res.length() - 1);
                    res.delete(0,20);
                    TypeReference<HashMap<String,String>> typeRef
                            = new TypeReference<HashMap<String,String>>() {};
                    HashMap<String,String> map = objectMapper.readValue(res.toString(), typeRef);
                    String price = map.get("05. price");
                    PrintWriter writer = response.getWriter();
                    out.print(price);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
