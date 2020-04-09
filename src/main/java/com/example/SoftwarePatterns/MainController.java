package com.example.SoftwarePatterns;


import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private StockRepository stockRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewStock(@RequestParam String title, @RequestParam String manufacturer, @RequestParam String category, @RequestParam String image, @RequestParam double price ){

        StockItem item = new StockItem(title, manufacturer, category, image, price);
        stockRepository.save(item);
        return "Saved!";

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StockItem> getAllStock() {
        // This returns a JSON or XML with the users
        return stockRepository.findAll();
    }
}
