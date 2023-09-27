DECLARE
    v_emple emple%rowtype;
    v_numero   emple.emp_no%TYPE := &empleado;
BEGIN
    SELECT
        *
    INTO v_emple
    FROM
        emple
    WHERE
        emp_no = v_numero;

    dbms_output.put_line('Apellido: '
                         || v_emple.apellido
                         || ' Oficio:'
                         || v_emple.oficio);

END;
