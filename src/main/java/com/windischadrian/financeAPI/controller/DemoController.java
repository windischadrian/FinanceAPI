//package com.windischadrian.demoAPI.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class DemoController {
//
//    @Autowired
//    private DemoService demoService;
//
//    @GetMapping("/get/{s1}")
//    public ResponseEntity<String> getDemoString(@PathVariable String s1) {
//        String demoString = demoService.serviceString(s1);
//
//        return new ResponseEntity<>(demoString, HttpStatus.OK);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<Iterable<DemoModel>> getAllRestaurants() {
//        Iterable<DemoModel> entries = demoService.getAllEntries();
//
//        return new ResponseEntity<>(entries, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<DemoModel> addRestaurant(@RequestBody DemoModel restaurantData) {
//
//        return new ResponseEntity<>(demoService.save(restaurantData), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<HttpStatus> deleteRestaurant(@RequestBody DemoModel restaurantData) {
//        demoService.delete(restaurantData);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
//
