package lab12.ex1.plugins;

import lab12.ex1.IPlugin;

public class Samsung implements IPlugin{
    private String name;
    private String version;
    private String camara;

    public Samsung(String name, String version, String camara) {
        this.name = name;
        this.version = version;
        this.camara = camara;
    }

    public Samsung() {
    }

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("coisas de Samsung");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    @Override
    public String toString() {
        return "Samsung [name=" + name + ", version=" + version + ", camara=" + camara + "]";
    }
    
}
