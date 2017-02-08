//Autories Carla Flores A01331363 y David Manzanarez A01337545

//Metodo 2
function GeneradorMediosCuadrados(semilla,iteraciones) {
    this.semilla = semilla;
    this.iteraciones = iteraciones;
    this.calcularMediosCuadrados = function() {
        
        var num=this.semilla;
        var aux=0;
        var padding=8;
        var aux_num="";
        var num_float=0.0;
        
        var arr_num=[];
        var arr_num_float=[];
        
        for(var i=0;i<this.iteraciones;i++){
            aux_num=((num*num)+aux).toString();
                
            while(aux_num.length<padding){
                aux_num="0"+aux_num;
            }
            
            aux_num=aux_num.substring(2, aux_num.length-2);
            num=parseInt(aux_num);            
            num_float=(((num))/10000.0);
            
            arr_num.push(num);
            arr_num_float.push(num_float);
        }        
        var arr_aux=[];
        arr_aux.push(arr_num);
        arr_aux.push(arr_num_float);        
        return arr_aux;
    };
}

//Metodo 1
function GeneradorCongruenciasLineales(semilla,a,c,m,iteraciones) {
    this.semilla = semilla;
    this.iteraciones = iteraciones;
    this.a=a;
    this.c=c;
    this.m=m;    
    
    this.calcularCongruenciasLineales = function() {
        var x=this.semilla;
        var res=0;
        var num_float=0.0;
        var arr_num=[];
        var arr_num_float=[];
            
        for(var i=0;i<this.iteraciones;i++){
            res=((this.a*x)+(this.c))%this.m
            num_float=(res/this.m);          
            
            arr_num.push(res);
            arr_num_float.push(num_float);
            
            x=res
        }
        
        var arr_aux=[];
        arr_aux.push(arr_num);
        arr_aux.push(arr_num_float);        
        return arr_aux;
    };
}

//Metodo 3
function GeneradorMultiplicativo(semilla,a,m,iteraciones) {
    this.semilla = semilla;
    this.iteraciones = iteraciones;
    this.a=a;
    this.m=m;
    
    this.calcularCongruenciasLineales = function() {
        var x=this.semilla;
        var res=0;
        var num_float=0.0;
        var arr_num=[];
        var arr_num_float=[];
            
        for(var i=1;i<=this.iteraciones;i++){
            res=((this.a*x))%m;
            num_float=(res/this.m);             
            x=res
            
            arr_num.push(res);
            arr_num_float.push(num_float);
        }
        
        var arr_aux=[];
        arr_aux.push(arr_num);
        arr_aux.push(arr_num_float);        
        return arr_aux;
        
    };
}



//            console.log("Generador: ("+this.a+"*"+x+"+"+this.c+")mod"+this.m);
//            console.log("Operacion: "+Math.floor(((this.a*x)+(this.c))/this.m)+"+"+res+"/"+this.m);
//            console.log("No. Aleatorio"+res);
//            console.log("R"+(i+1)+"="+num_float);



