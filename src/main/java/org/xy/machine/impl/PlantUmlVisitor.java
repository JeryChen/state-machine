package org.xy.machine.impl;

import org.xy.machine.State;
import org.xy.machine.StateMachine;
import org.xy.machine.Transition;
import org.xy.machine.Visitor;

/**
 * <功能介绍><br>
 * <p>
 * <PlantUML Visitor>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PlantUmlVisitor implements Visitor {

    /**
     * 执行时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    @Override
    public String visitOnEntry(StateMachine<?, ?, ?> visitable) {
        return "@startuml" + LF;
    }

    /**
     * 退出时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    @Override
    public String visitOnExit(StateMachine<?, ?, ?> visitable) {
        return "@enduml";
    }

    /**
     * 执行时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    @Override
    public String visitOnEntry(State<?, ?, ?> visitable) {
        StringBuilder sb = new StringBuilder();
        //noinspection rawtypes
        for (Transition transition : visitable.getTransitions()) {
            sb.append(transition.getSource().getId())
              .append(" --> ")
              .append(transition.getTarget().getId())
              .append(" : ")
              .append(transition.getEvent())
              .append(LF);
        }
        return sb.toString();
    }

    /**
     * 退出时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    @Override
    public String visitOnExit(State<?, ?, ?> visitable) {
        return "";
    }
}
