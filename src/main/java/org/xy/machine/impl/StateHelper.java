package org.xy.machine.impl;

import org.xy.machine.State;

import java.util.Map;
import java.util.Objects;

/**
 * <功能介绍><br>
 * <p>
 * <状态助手类>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateHelper {

    public static <S, E, C> State<S, E, C> getState(Map<S, State<S, E, C>> stateMap, S stateId){
        State<S, E, C> state = stateMap.get(stateId);
        if (Objects.isNull(state)) {
            state = new StateImpl<>(stateId);
            stateMap.put(stateId, state);
        }
        return state;
    }
}
