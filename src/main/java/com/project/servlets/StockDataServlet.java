package com.project.servlets;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.project.Service.StockService;
import com.project.entities.Stocks;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@WebServlet(name = "StockDataServlet", value = "/StockDataServlet")
public class StockDataServlet extends HttpServlet {
    private final StockService stockService;
    public StockDataServlet() {
        this.stockService = new StockService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(request, response);
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String stockName = request.getParameter("stockName");
            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockName + "&apikey=DSG6OJ6OOJ3WQ2BS";
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
                res.deleteCharAt(res.length()-1);
                if(res.substring(21).equals("{}")){
                    Stocks stock=null;
                    session.setAttribute("stocky", stock);
                    response.sendRedirect("viewStock.jsp");
                }
                else {
                 Stocks stock = objectMapper.readValue(res.substring(21), Stocks.class);
//                Stock stock = (Stock) gson.fromJson(res.toString(), Stock.class);

                session.setAttribute("stocky", stock);
                response.sendRedirect("viewStock.jsp");
            }
        }}
        catch (Exception e){
            e.printStackTrace();
        }
        StockService stockService = new StockService();
        String jsonResponse = this.stockService.getStockListJson();
        outputResponse(request, response, jsonResponse, 200);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        super.doPost(request, response);
//        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        int rc = HttpServletResponse.SC_OK;
//        boolean res= this.stockService.createStock(requestBody);
//        if(!res){
//            rc = HttpServletResponse.SC_BAD_REQUEST;
//        }
//        outputResponse(request, response, null, rc);
//    }

    private void outputResponse(HttpServletRequest request, HttpServletResponse response, String payload, int statusCode) throws IOException {
        response.setHeader("Content-Type", "application/json");
        try{
            response.setStatus(statusCode);
            if(payload != null){
                OutputStream out = response.getOutputStream();
                out.write(payload.getBytes());
                out.flush();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
