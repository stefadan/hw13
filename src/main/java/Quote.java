import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Quote {
    private int id;
    private String author;
    private String quote;
    @Setter public boolean favourite;
}
