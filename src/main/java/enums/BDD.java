/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author ts1sio
 */
public enum BDD {
    DISTANTE("jdbc:mariadb://172.20.177.250:3306/24IOONOMS", "ADM_IOONOMS", "mpSdis24Ioonoms"),
    PRODUCTION("jdbc:mariadb://127.0.0.1:3306/24IOONOMS", DISTANTE.user, DISTANTE.password),
    LOCAL("jdbc:mariadb://127.0.0.1:3307/sdis", "root", "");
    
    public final String url;
    public final String user;
    public final String password;
    
    private BDD(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
}
