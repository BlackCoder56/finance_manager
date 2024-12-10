
package codePackage;


public class Type {
    int id;
    String typeName;
    
    public Type(int id, String typeName){
        this.id = id;
        this.typeName = typeName;
    }
    
    public int toInt(){
        return id;
    }
    
}



 
//     public class category{
//        
//        String id;
//        String cname;
//        
//        public category(String id,String ccname){
//            
//            this.id = id;
//            this.cname = ccname;
//            
//        }
//        
//        public String toString(){
//         
//           return cname; 
//        }
//        
//    }