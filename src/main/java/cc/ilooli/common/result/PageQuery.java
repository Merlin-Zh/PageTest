package cc.ilooli.common.result;

import lombok.Data;

/**
 * 页面查询
 *
 * @author OVO
 * @date 2021/11/10
 */
@Data
public class PageQuery {
    /** 当前行 */
    private int currentLine;
    /** 页面大小 */
    private Integer pageSize = 20;
    /** 当前页面 */
    private Integer currentPage = 1;
}
