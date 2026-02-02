package com.jsondata.carjson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertCarToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Car car = new Car("Honda", "City", 1200000);

            // convert object to JSON
            String json = mapper.writeValueAsString(car);

            System.out.println("Generated JSON:");
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
