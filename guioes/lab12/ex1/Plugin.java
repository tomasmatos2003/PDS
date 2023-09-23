package lab12.ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lab12.ex1.plugins.*;

public class Plugin {
    public static void main(String[] args) throws Exception {
        File proxyList = new File("lab12/ex1/plugins/");
        ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
        for (String f : proxyList.list()) {
            if (f.endsWith(".class")) {
                try {
                    plgs.add(PluginManager.load("lab12.ex1.plugins."+f.substring(0, f.lastIndexOf('.'))));
                } catch (Exception e) {
                    System.out.println("\t" + f + ": Componente ignorado. Não é IPlugin.");
                }
            }
        }
        List<IPlugin> l = new ArrayList<>();

        Iterator<IPlugin> it = plgs.iterator();
        while (it.hasNext()) {

            IPlugin p = it.next();

            p.fazQualQuerCoisa();

            if (p instanceof IPhone) {
                ((IPhone) p).setCamara("50mpx");
            
            }else if (p instanceof Nokia) {
                ((Nokia) p).setCamara("100mpx");
            } else if (p instanceof Samsung) {
                ((Samsung) p).setCamara("200mpx");
            }
            l.add(p);
        }

        for (IPlugin p : l) {
            System.out.println(p);
        }
        
    }
}
