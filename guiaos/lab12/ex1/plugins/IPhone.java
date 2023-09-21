package lab12.ex1.plugins;

import lab12.ex1.IPlugin;


public class IPhone implements IPlugin {

    private String name;
    private String version;
    private String camara;

    public IPhone(String name, String version, String camara) {
        this.name = name;
        this.version = version;
        this.camara = camara;
    }

    public IPhone() {
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("coisas de Iphone");
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getCamara() {
        return this.camara;
    }

    @Override
    public String toString() {
        return "IPhone [name=" + name + ", version=" + version + ", camara=" + camara + "]";
    }
    
}
