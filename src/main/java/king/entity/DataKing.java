package king.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import king.helper.DateHelper;
import king.helper.StringHelper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DataKing {
    private String id;
    private String status;
    @JsonDeserialize(using = DateHelper.class)
    private Date createdOn;
    @JsonDeserialize(using = StringHelper.class)
    private String name;
    private String description;
    private int delta;

    @JsonCreator
    public DataKing(String id, String status, @JsonProperty Date createdOn, @JsonProperty String name, String description, int delta) {
        this.id = id;
        this.status = status;
        this.createdOn = createdOn;
        this.name = name;
        this.description = description;
        this.delta = delta;
    }
}
