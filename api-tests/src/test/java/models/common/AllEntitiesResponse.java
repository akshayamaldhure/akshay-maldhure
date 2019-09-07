package models.common;

import lombok.Getter;

import java.util.List;

/**
 * Response to a successful HTTP request
 * @param <T> The type of entity, e.g. Product.
 */
@Getter
public class AllEntitiesResponse<T> {
    private long total;
    private long limit;
    private int skip;
    private List<T> data;

    public long getDataCount() {
        return data.size();
    }
}
