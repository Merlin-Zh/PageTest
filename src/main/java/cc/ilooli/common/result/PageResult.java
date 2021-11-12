package cc.ilooli.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果
 *
 * @author OVO
 * @date 2021/11/12
 */
@Data
@NoArgsConstructor
public class PageResult<E> {
    private Integer currentPage = 1;
    private Long totalPage;
    private Long totalCount;
    private List<E> list;

    public PageResult(PageQuery query, Long totalCount, List<E> list) {
        this.currentPage = query.getCurrentPage();
        this.totalPage = totalCount % query.getPageSize() == 0 ?
                totalCount / query.getPageSize() : totalCount / query.getPageSize() + 1;
        this.totalCount = totalCount;
        this.list = list;
    }
}
