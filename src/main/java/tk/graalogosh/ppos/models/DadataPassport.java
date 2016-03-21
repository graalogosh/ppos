package tk.graalogosh.ppos.models;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 21.02.2016.
 */
public class DadataPassport {
    private final String source;
    private final String series;
    private final String number;
    private final DadataQuality qc;

    public DadataPassport(String source, String series, String number, DadataQuality qc) {
        this.source = source;
        this.series = series;
        this.number = number;
        this.qc = qc;
    }

    public String getSource() {
        return source;
    }

    public String getSeries() {
        return series;
    }

    public String getNumber() {
        return number;
    }

    public DadataQuality getQuality() {
        return qc;
    }


}
enum DadataQuality{
    VALID (0),
    INVALID_FORMAT (1),
    EMPTY_SOURCE (2),
    INVALID(10);

    private Integer value;
    DadataQuality(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
enum DadataHttpCode{
    OK (200),
    INVALID_QUERY (400),
    INVALID_API_OR_SECRET_KEY (401),
    NO_MONEY (402),
    INVALID_KEY (403),
    NOT_POST_QUERY (405),
    TOO_MUCH_ENTRIES (413),
    INTERNAL_ERROR(500);

    private Integer value;
    DadataHttpCode(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
