DECLARE
    CURSOR cursor1 IS
    SELECT
        emp_no,
        apellido
    FROM
        emple
    WHERE
        EXTRACT(YEAR FROM fecha_alt) = 1990;

    v_cursor1 cursor1%rowtype;
BEGIN
    OPEN cursor1;
    LOOP
        FETCH cursor1 INTO v_cursor1;
        EXIT WHEN cursor1%notfound;
        dbms_output.put_line(v_cursor1.emp_no
                             || 'LLAMADO'
                             || v_cursor1.apellido);
    END LOOP;

    CLOSE cursor1;
END;