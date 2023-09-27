DECLARE
--variable para pedir el numero de departamento
    v_deptnum  depart.dept_no%TYPE := &departamento;
--variable para el numero de empleados de un departamento
    v_numemple NUMBER;
--variable para guardar el salario un vez actualizado
    v_salario  NUMBER;
BEGIN
--select para contar el numero de empleados de un departamento
    SELECT
        COUNT(*)
    INTO v_numemple
    FROM
        emple e
    WHERE
        e.dept_no = v_deptnum;
--los if con un between vemos si el valor esta actualizamos el salario lo metemos en una variable y lo mostramos
    IF v_numemple BETWEEN 1 AND 2 THEN
        UPDATE emple e
        SET
            salario = salario + ( salario * ( 1 / 10 ) )
        WHERE
            e.dept_no = v_deptnum;

        SELECT
            salario
        INTO v_salario
        FROM
                 emple e
           WHERE
            e.dept_no = v_deptnum;  

        dbms_output.put_line('El salario de los empleados del departamento con codigo  '
                             || v_deptnum
                             || ' es ahora '
                             || v_salario);
    ELSIF v_numemple BETWEEN 2 AND 4 THEN
        UPDATE emple e
        SET
            salario = salario + ( salario * ( 30 / 200 ) )
        WHERE
            e.dept_no = v_deptnum;

        SELECT
            salario
        INTO v_salario
        FROM
                 emple e
            WHERE
            e.dept_no = v_deptnum;  
            

        dbms_output.put_line('El salario de los empleados del departamento con codigo  '
                             || v_deptnum
                             || ' es ahora '
                             || v_salario);
    ELSIF v_numemple > 4 THEN
        UPDATE emple e
        SET
            salario = salario + ( salario * ( 2 / 10 ) )
        WHERE
            e.dept_no = v_deptnum;

        SELECT
            salario
        INTO v_salario
        FROM
                 emple e
           WHERE
            e.dept_no = v_deptnum;  

        dbms_output.put_line('El salario de los empleados del departamento con codigo  '
                             || v_deptnum
                             || ' es ahora '
                             || v_salario);
--sino se cumple ninguna de estas tres opciones es porque el departamento no tendra empleados
    ELSE
        dbms_output.put_line('El codigo '
                             || v_deptnum
                             || ' no existe');
    END IF;

END;
/