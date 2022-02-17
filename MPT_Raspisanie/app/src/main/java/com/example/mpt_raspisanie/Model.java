package com.example.mpt_raspisanie;

public class Model {
    private String day;
    private String para11;
    private String para12;
    private String para2;
    private String para31;
    private String para32;
    private String para41;
    private String para42;
    private String para5;
    private String para6;

    //Конструктор
    public Model(String day, String para11,String para12, String para2, String para31, String para32, String para41, String para42, String para5, String para6)
    {
        this.day=day;
        this.para11=para11;
        this.para12=para12;
        this.para2=para2;
        this.para31=para31;
        this.para32=para32;
        this.para41=para41;
        this.para42=para42;
        this.para5=para5;
        this.para6=para6;
    }
    public String getDay(){return day;}
    public void setDay(String day){this.day=day;}
    public String getPara11(){return para11;}
    public void setPara11(String para11){this.para11=para11;}
    public String getPara12(){return para12;}
    public void setPara12(String para12){this.para12=para12;}
    public String getPara2(){return para2;}
    public void setPara2(String para2){this.para2=para2;}
    public String getPara31(){return para31;}
    public void setPara31(String para31){this.para31=para31;}
    public String getPara32(){return para32;}
    public void setPara32(String para32){this.para32=para32;}
    public String getPara41(){return para41;}
    public void setPara41(String para41){this.para41=para41;}
    public String getPara42(){return para42;}
    public void setPara42(String para42){this.para42=para42;}
    public String getPara5(){return para5;}
    public void setPara5(String para5){this.para5=para5;}
    public String getPara6(){return para6;}
    public void setPara6(String para6){this.para6=para6;}

}
