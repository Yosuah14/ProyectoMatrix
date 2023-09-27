    v_departamento depart.dept_no%TYPE;
    v_nombre       depart.dnombre%TYPE;
    CURSOR c_empleados IS
    SELECT
    dept_no,
    COUNT(*)
    FROM
        emple where dept_no=20 group by dept_no;

    v_oficio       emple.oficio%TYPE;
    v_emple        NUMBER;
    
    
        for
    emp
    in
    c_empleados
    loop
    v_oficio:=emp.oficio;
     DBMS_OUTPUT.PUT_LINE
    ( 'Oficio: ' || v_oficio );
    
    end loop;
    
    
    
    
     select
            apellido,oficio 
            into v_apellido,v_oficio
            from emple
            where 
            apellido=dept.apellido and
            oficio=dept.oficio;
        dbms_output.put_line('Apellido del empleado:'||v_apellido);
        dbms_output.put_line('Oficio del empleado:'||v_oficio);
        
        
        
            v_oficio emple.oficio%type;
    v_apellido emple.apellido%type;
    
    
    
    
    select
            apellido,oficio 
            into v_apellido,v_oficio
            from emple
            where 
            dept_no=20 
            ;