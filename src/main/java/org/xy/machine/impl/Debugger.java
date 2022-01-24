package org.xy.machine.impl;

/**
 * <功能介绍><br>
 * <p>
 * <Debugger，用于解耦 Logging 框架依赖>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Debugger {

    private static boolean isDebugOn = false;

    public static void debug(String message) {
        if (isDebugOn) {
            System.out.println(message);
        }
    }

    public static void enableDebug() {
        isDebugOn = true;
    }
}
