package org.xy.machine;

/**
 * <功能介绍><br>
 * <p>
 * <访问者>
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Visitor {

    char LF = '\n';

    /**
     * 执行时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    String visitOnEntry(StateMachine<?, ?, ?> visitable);

    /**
     * 退出时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    String visitOnExit(StateMachine<?, ?, ?> visitable);

    /**
     * 执行时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    String visitOnEntry(State<?, ?, ?> visitable);

    /**
     * 退出时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    String visitOnExit(State<?, ?, ?> visitable);
}
