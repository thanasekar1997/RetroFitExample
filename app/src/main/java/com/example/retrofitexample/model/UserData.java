package com.example.retrofitexample.model;

public class UserData {
    DataClass data;
    Support support;

    public DataClass getData() {
        return data;
    }

    public void setData(DataClass data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    class DataClass{

        String first_name;
        String last_name;
        String id;
        String email;
        String avatar;
        public DataClass(String first_name, String last_name, String id, String email, String avatar) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.id = id;
            this.email = email;
            this.avatar = avatar;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "DataClass{" +
                    "first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", id='" + id + '\'' +
                    ", email='" + email + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }
    class Support{
        String url,text;

        public Support(String url, String text) {
            this.url = url;
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
