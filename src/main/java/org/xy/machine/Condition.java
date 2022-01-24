package org.xy.machine;

/**
 * <功能介绍><br>
 * <p>
 * <条件>
 * 表示是否允许到达某个状态
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Condition<C> {

    /**
     * 是否满足条件
     *
     * @param context context 上下文信息
     *
     * @return 上下文是否满足当前条件
     */
    boolean isSatisfied(C context);

    /**
     * 获取默认类简单名
     *
     * @return 类名
     */
    default String name() {
        return this.getClass().getSimpleName();
    }
}
