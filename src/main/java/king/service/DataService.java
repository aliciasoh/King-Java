package king.service;

import king.dao.DataDAO;
import king.dto.DataDTO;
import king.entity.DataKing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Configuration
@PropertySource("classpath:config.properties")
public class DataService implements DataDAO {

    private RestTemplate template;
    private String baseUrl;

    @Autowired
    public DataService(RestTemplate template, @Value("${data.url}") String baseUrl){
        this.template = template;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<DataKing> getData() {
        try{
            DataDTO response = template.getForObject(
                    baseUrl,
                    DataDTO.class);
            List<DataKing> dataKingList = response.getOutput();
            return dataKingList;
        }
        catch(Exception e){
            throw e;
        }
    }
}
