--mostrar el nombre del deaprtamento y dentro la cantidad de 
--empleados y el nombre y oficio de cada empleado

CREATE OR REPLACE PROCEDURE mostrarinfodepartamentos IS

    CURSOR c_departamentos IS
    SELECT
        dept_no,
        dnombre
    FROM
        depart;

    v_cantemple NUMBER;
    v_oficio    emple.oficio%TYPE;
    v_apellido  emple.apellido%TYPE;
BEGIN
    FOR d IN c_departamentos LOOP
        dbms_output.put_line('Nombre del Departamento: ' || d.dnombre);
        SELECT
            COUNT(*)
        INTO v_cantemple
        FROM
            emple
        WHERE
            dept_no = d.dept_no;

        dbms_output.put_line('Cantidad de empleados:' || v_cantemple);
        FOR e IN ( SELECT apellido, oficio
            FROM emple WHERE dept_no = d.dept_no ) LOOP
            dbms_output.put_line('Apellido del empleado:' || e.apellido);
            dbms_output.put_line('Oficio del empleado:' || e.oficio);
        END LOOP;

    END LOOP;
END;
/

BEGIN
    mostrarinfodepartamentos;
END;