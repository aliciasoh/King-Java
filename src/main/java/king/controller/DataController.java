package king.controller;

import king.entity.DataKing;
import king.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/data")
    public List<DataKing> getData(){
        return dataService.getData();
    }
}
