package org.testing.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ScenarioContext {
    private static ScenarioContext instance;
    private final Map<Keys, Object> scenarioContext;

    private ScenarioContext() {
        scenarioContext = new ConcurrentHashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void setValueToContext(Keys key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getValueFromContext(Keys key) {
        return scenarioContext.get(key);
    }
    public void clearContext() {
        scenarioContext.clear();
    }
}


/*public class ScenarioContext {

    private final Map<String, Object> scenarioContext;
    private static ScenarioContext scenarioInstance = null;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getScenarioInstance() {
        if (scenarioInstance == null) {
            scenarioInstance = new ScenarioContext();
        }
        return scenarioInstance;
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

}


*/
