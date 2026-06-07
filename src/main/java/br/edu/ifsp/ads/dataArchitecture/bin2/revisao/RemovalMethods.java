package br.edu.ifsp.ads.dataArchitecture.bin2.revisao;

import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.model.Node;
import br.edu.ifsp.ads.dataArchitecture.bin2.revisao.utils.Utils;

public class RemovalMethods {
    public static void insertUnique( Node node ){

    }

    public static boolean exists(int value, Node root){
        if(Utils.isNull(root)){
            return false;
        } else{
            if(Utils.isEqual(value, root)){
                return true;
            }
            boolean existsInRight = exists(value, root.right);
            boolean existsInLeft = exists(value, root.left);

            return existsInLeft || existsInRight;
        }

    }

}
