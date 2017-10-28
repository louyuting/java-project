package com.example.fastjson.domain;

import java.util.List;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/7
 */
public class User {
    List<Info> id;
        String name;

        public List<Info> getId() {
            return id;
        }

        public void setId(List<Info> id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.id.toString() + " ---- " +this.name;
        }
}
