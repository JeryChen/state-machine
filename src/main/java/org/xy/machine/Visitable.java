package org.xy.machine;

/**
 * <功能介绍><br>
 * <p>
 * <可访问的>
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Visitable {

    /**
     * 接受处理
     *
     * @param visitor 访问者
     *
     * @return 访问者进入和退出结果
     */
    String accept(Visitor visitor);
}
