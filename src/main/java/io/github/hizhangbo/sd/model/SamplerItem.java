package io.github.hizhangbo.sd.model;

import com.alibaba.fastjson2.JSONObject;

/**
 * Example
 * {
 *      "name": "Euler a",
 *      "aliases": [
 *          "k_euler_a",
 *          "k_euler_ancestral"
 *      ],
 *      "options": {}
 * }
 */
public class SamplerItem {

    private String name;
    private String[] aliases;
    private JSONObject options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public JSONObject getOptions() {
        return options;
    }

    public void setOptions(JSONObject options) {
        this.options = options;
    }
}
