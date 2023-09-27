declare
v_funcion ce_personal.funcion%type :='&funciones1';
v_empleados number;
v_suma number;
begin
total_empleados(v_funcion,v_suma,v_empleados);
 DBMS_OUTPUT.PUT_LINE('La suma de los salarios de '||v_funcion ||' es '||v_suma||' y la suma de todos los empleados es ' ||v_empleados);
 
end;
/