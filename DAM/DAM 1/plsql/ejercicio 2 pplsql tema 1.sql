DECLARE
    numero    NUMBER;
    depnum    NUMBER := &departamento;
    v_dnombre depart.dnombre%TYPE;
BEGIN
    SELECT COUNT(*) into numero FROM depart WHERE dept_no = depnum;
    IF numero > 0 THEN
        SELECT d.dnombre, COUNT(*)
        INTO v_dnombre, numero
        FROM emple e INNER JOIN depart d ON ( e.dept_no = d.dept_no )
        WHERE d.dept_no = v_dnombre
        GROUP BY d.dnombre;
        dbms_output.put_line('DEPARTAMENTO: ' || v_dnombre);
        dbms_output.put_line('Nº EMPLEDOS : ' || numero);
    ELSE
        dbms_output.put_line('El departamento no existe');
    END IF;
END;
/