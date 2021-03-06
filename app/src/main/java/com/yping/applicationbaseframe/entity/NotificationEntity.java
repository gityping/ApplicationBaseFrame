package com.yping.applicationbaseframe.entity;

import java.util.List;

public class NotificationEntity {

    /**
     * counts : 20
     * data : [{"_id":"5e5533abefd6f28e2554f492","author":"鸢媛","category":"Girl","createdAt":"2020-03-13 08:00:00","desc":"当你要开口说话时，你所说的话，必须比沉默更有价值。 \u200b \u200b\u200b\u200b\u200b","images":["http://gank.io/images/21c417e3a84842bfa585dee686f6b992"],"likeCounts":0,"publishedAt":"2020-03-13 08:00:00","stars":1,"title":"第23期","type":"Girl","url":"http://gank.io/images/21c417e3a84842bfa585dee686f6b992","views":631},{"_id":"5e9591c60bd5529b54e712af","author":"鸢媛","category":"Girl","createdAt":"2020-05-20 08:00:00","desc":"希望下一次，能喜欢上一个也喜欢自己的人 \u200b\u200b\u200b\u200b。","images":["http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b"],"likeCounts":0,"publishedAt":"2020-05-20 08:00:00","stars":1,"title":"第91期","type":"Girl","url":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","views":286},{"_id":"5e959200ee6ba981da2af34d","author":"鸢媛","category":"Girl","createdAt":"2020-05-22 08:00:00","desc":"长不过执念，短不过善变。","images":["http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149"],"likeCounts":0,"publishedAt":"2020-05-22 08:00:00","stars":1,"title":"第93期","type":"Girl","url":"http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149","views":382},{"_id":"5e959107808d6d2fe6b56ed2","author":"鸢媛","category":"Girl","createdAt":"2020-05-15 08:00:00","desc":"爱一个人最好的方式， \n是经营好自己； 爱人要有度，留一点自我， \n才会有自尊，你的付出才会有人重视。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2"],"likeCounts":1,"publishedAt":"2020-05-15 08:00:00","stars":1,"title":"第86期","type":"Girl","url":"http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2","views":459},{"_id":"5e958fe40bd5529b54e712a6","author":"鸢媛","category":"Girl","createdAt":"2020-04-30 08:00:00","desc":"其实也不是什么忘不掉的人\n只是对那场无结果的付出和被浪费的炽热的爱\n耿耿于怀罢了","images":["http://gank.io/images/291ee91a554f4cd88bf9a09a9fa2e95e"],"likeCounts":0,"publishedAt":"2020-04-30 08:00:00","stars":1,"title":"第71期","type":"Girl","url":"http://gank.io/images/291ee91a554f4cd88bf9a09a9fa2e95e","views":246},{"_id":"5e55339cefd6f28e2554f48e","author":"鸢媛","category":"Girl","createdAt":"2020-03-11 08:00:00","desc":"时光太瘦，指缝太宽，不经意的一瞥，已隔经年。","images":["http://gank.io/images/94c30acee68340278dfc58e948109ab9"],"likeCounts":0,"publishedAt":"2020-03-11 08:00:00","stars":1,"title":"第21期","type":"Girl","url":"http://gank.io/images/94c30acee68340278dfc58e948109ab9","views":210},{"_id":"5e7785ba181a6495ef1172ad","author":"鸢媛","category":"Girl","createdAt":"2020-03-29 08:00:00","desc":"突如其来的脾气，往往是积攒很久了的委屈。❤","images":["http://gank.io/images/e6b78c1949d5438fa37ff2f272e5f1d0"],"likeCounts":0,"publishedAt":"2020-03-29 08:00:00","stars":1,"title":"第39期","type":"Girl","url":"http://gank.io/images/e6b78c1949d5438fa37ff2f272e5f1d0","views":648},{"_id":"5e958faf808d6d2fe6b56ecb","author":"鸢媛","category":"Girl","createdAt":"2020-04-27 08:00:00","desc":"相似的人适合玩闹/互补的人才能终老。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/4817628a6762410895f814079a6690a1"],"likeCounts":0,"publishedAt":"2020-04-27 08:00:00","stars":1,"title":"第68期","type":"Girl","url":"http://gank.io/images/4817628a6762410895f814079a6690a1","views":420},{"_id":"5e529d2a2adf62a2ba021cfb","author":"鸢媛","category":"Girl","createdAt":"2020-03-01 08:00:00","desc":"念念不忘的东西，一开始都美好的不像话。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/3e4423173d0a4c5e8447c0335b4458fc"],"likeCounts":1,"publishedAt":"2020-03-01 08:00:00","stars":4,"title":"第11期","type":"Girl","url":"http://gank.io/images/3e4423173d0a4c5e8447c0335b4458fc","views":991},{"_id":"5e8c80682bce50b3ceaa80ea","author":"鸢媛","category":"Girl","createdAt":"2020-04-07 08:00:00","desc":"当你越来越优秀的时候，就会遇见越来越好的人。","images":["http://gank.io/images/341ecaacdd7d4cc09cd0de100f3eab46"],"likeCounts":0,"publishedAt":"2020-04-07 08:00:00","stars":1,"title":"第48期","type":"Girl","url":"http://gank.io/images/341ecaacdd7d4cc09cd0de100f3eab46","views":441},{"_id":"5e72321065c5e56de1a75589","author":"鸢媛","category":"Girl","createdAt":"2020-03-20 08:00:00","desc":"心里藏着疲惫和委屈\n面上却在尽力讨好生活","images":["http://gank.io/images/be3c70b17f364596b25f301a55164882"],"likeCounts":1,"publishedAt":"2020-03-20 08:00:00","stars":1,"title":"第30期","type":"Girl","url":"http://gank.io/images/be3c70b17f364596b25f301a55164882","views":791},{"_id":"5e77740db8ea09cade05263e","author":"鸢媛","category":"Girl","createdAt":"2020-03-24 08:00:00","desc":"心里藏着疲惫和委屈,\n面上却在尽力讨好生活","images":["http://gank.io/images/b140f015a16e444aad6d76262f676a78"],"likeCounts":1,"publishedAt":"2020-03-24 08:00:00","stars":1,"title":"第34期","type":"Girl","url":"http://gank.io/images/b140f015a16e444aad6d76262f676a78","views":2012},{"_id":"5e5149256e7524f833c3f7a4","author":"鸢媛","category":"Girl","createdAt":"2020-02-27 08:00:00","desc":"原是今生今世已惘然， 山河岁月空惆怅， 而我，终将是要等着你的。","images":["http://gank.io/images/02eb8ca3297f4931ab64b7ebd7b5b89c"],"likeCounts":7,"publishedAt":"2020-02-27 08:00:00","stars":1,"title":"第8期","type":"Girl","url":"http://gank.io/images/02eb8ca3297f4931ab64b7ebd7b5b89c","views":2412},{"_id":"5e5149066e7524f833c3f7a2","author":"鸢媛","category":"Girl","createdAt":"2020-02-26 08:00:00","desc":"你看街上依旧繁花似锦，阳光依然璀璨温柔。总有一天，你会遇到一个彩虹般的人，从此以后，其他人不过是匆匆浮云。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/3a1997f4ecfb4a65ad84692fea3123bf"],"likeCounts":0,"publishedAt":"2020-02-26 08:00:00","stars":1,"title":"第7期","type":"Girl","url":"http://gank.io/images/3a1997f4ecfb4a65ad84692fea3123bf","views":429},{"_id":"5e958f2dee6ba981da2af33a","author":"鸢媛","category":"Girl","createdAt":"2020-04-19 08:00:00","desc":"对任何热爱的事情都要全力以赴/包括喜欢自己。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/a2d3115b8d464d93933e79e88af03580"],"likeCounts":2,"publishedAt":"2020-04-19 08:00:00","stars":1,"title":"第60期","type":"Girl","url":"http://gank.io/images/a2d3115b8d464d93933e79e88af03580","views":553},{"_id":"5e51493b6e7524f833c3f7a6","author":"鸢媛","category":"Girl","createdAt":"2020-02-28 08:00:00","desc":"曾踏月而来，只因你在山中。山风拂发、拂颈、拂裸露的肩膀，而月光衣我以华裳 。","images":["http://gank.io/images/89c170bf253346d98240d456cbc1c688"],"likeCounts":0,"publishedAt":"2020-02-28 08:00:00","stars":1,"title":"第9期","type":"Girl","url":"http://gank.io/images/89c170bf253346d98240d456cbc1c688","views":342},{"_id":"5e958ee017bf93950887f208","author":"鸢媛","category":"Girl","createdAt":"2020-04-15 08:00:00","desc":"愿所期之事皆能成，所念之人皆能到。 ","images":["http://gank.io/images/28fc02e86d584ff08802c8dcd9535b35"],"likeCounts":0,"publishedAt":"2020-04-15 08:00:00","stars":1,"title":"第56期","type":"Girl","url":"http://gank.io/images/28fc02e86d584ff08802c8dcd9535b35","views":387},{"_id":"5e959012808d6d2fe6b56ecc","author":"鸢媛","category":"Girl","createdAt":"2020-05-03 08:00:00","desc":"我们曾如此期待他人的认同，到最后才知道，世界是自己的，与他人毫无关系。","images":["http://gank.io/images/f7b320f1a89a4aaebadb1922c2a7a368"],"likeCounts":0,"publishedAt":"2020-05-03 08:00:00","stars":1,"title":"第74期","type":"Girl","url":"http://gank.io/images/f7b320f1a89a4aaebadb1922c2a7a368","views":223},{"_id":"5e958f7d808d6d2fe6b56ec9","author":"鸢媛","category":"Girl","createdAt":"2020-04-24 08:00:00","desc":"心里藏着小星星，生活才能亮晶晶。 \u200b\u200b","images":["http://gank.io/images/1a515f1508e345e2bf24673c2c2d50c4"],"likeCounts":0,"publishedAt":"2020-04-24 08:00:00","stars":1,"title":"第65期","type":"Girl","url":"http://gank.io/images/1a515f1508e345e2bf24673c2c2d50c4","views":312},{"_id":"5e53d842773c439beff19bf6","author":"鸢媛","category":"Girl","createdAt":"2020-03-10 08:00:00","desc":"故人笑比庭中树，一日秋风一日疏。","images":["http://gank.io/images/59019eedff4540cd88c96cb96937465f"],"likeCounts":0,"publishedAt":"2020-03-10 08:00:00","stars":1,"title":"第20期","type":"Girl","url":"http://gank.io/images/30f70718ee274bb399a1069f9eb79ead","views":199}]
     * status : 100
     */

    private int counts;
    private int status;
    private List<DataBean> data;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 5e5533abefd6f28e2554f492
         * author : 鸢媛
         * category : Girl
         * createdAt : 2020-03-13 08:00:00
         * desc : 当你要开口说话时，你所说的话，必须比沉默更有价值。 ​ ​​​​
         * images : ["http://gank.io/images/21c417e3a84842bfa585dee686f6b992"]
         * likeCounts : 0
         * publishedAt : 2020-03-13 08:00:00
         * stars : 1
         * title : 第23期
         * type : Girl
         * url : http://gank.io/images/21c417e3a84842bfa585dee686f6b992
         * views : 631
         */

        private String _id;
        private String author;
        private String category;
        private String createdAt;
        private String desc;
        private int likeCounts;
        private String publishedAt;
        private int stars;
        private String title;
        private String type;
        private String url;
        private int views;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getLikeCounts() {
            return likeCounts;
        }

        public void setLikeCounts(int likeCounts) {
            this.likeCounts = likeCounts;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public int getStars() {
            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
