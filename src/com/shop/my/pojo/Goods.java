package com.shop.my.pojo;


public class Goods {
    private Integer id;   //商品编号
    private String gname; //商品名称
    private Double goprice;  //商品原价
    private Double grprice;  //商品现价
    private Integer gstore;  //商品库存
    private String gpicture;     //图片
    private Integer goodstype_id;   //类型id
    private String typename; //商品类型，查询时使用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGoprice() {
        return goprice;
    }

    public void setGoprice(Double goprice) {
        this.goprice = goprice;
    }

    public Double getGrprice() {
        return grprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public Integer getGstore() {
        return gstore;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }


    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public Integer getGoodstype_id() {
        return goodstype_id;
    }

    public void setGoodstype_id(Integer goodstype_id) {
        this.goodstype_id = goodstype_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
