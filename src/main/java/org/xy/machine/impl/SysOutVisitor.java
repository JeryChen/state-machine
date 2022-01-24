package org.xy.machine.impl;

import org.xy.machine.State;
import org.xy.machine.StateMachine;
import org.xy.machine.Transition;
import org.xy.machine.Visitor;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SysOutVisitor implements Visitor {

    /**
     * 执行时访问
     *
     * @param visitable 要访问的元素
     *
     * @return 有序序列图
     */
    @Override
    public String visitOnEntry(StateMachine<?, ?, ?> visitable) {
        String entry = "-----StateMachine:" + visitable.getMachineId() + " entry-------";
        System.out.println(entry);
        return entry;
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
        String exit = "-----StateMachine:" + visitable.getMachineId() + " exit-------";
        System.out.println(exit);
        return exit;
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
        String stateStr = "State:" + visitable.getId();
        sb.append(stateStr)
          .append(LF);
        System.out.println(stateStr);
        for (Transition transition : visitable.getTransitions()) {
            String transitionStr = "    Transition:" + transition;
            sb.append(transitionStr)
              .append(LF);
            System.out.println(transitionStr);
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
