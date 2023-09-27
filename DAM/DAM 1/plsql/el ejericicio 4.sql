CREATE OR REPLACE FUNCTION TotalPagosCliente (
    v_id NUMBER
) RETURN number is 
contador number;
v_boolean boolean;
begin 
v_boolean:=existeclientebyld(v_id); 
IF v_boolean THEN
    SELECT
       
        SUM(total)
    INTO contador
    FROM
             pago 
       
    WHERE
        codigo_cliente = v_id;
    
    RETURN contador;
    ELSE
        RETURN -1;
    end if;
end;
/


begin

end;
/

   