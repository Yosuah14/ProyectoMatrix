--PARTE 1
CREATE OR REPLACE FUNCTION hay_accid_tipo (
    idpacien s_tipos_accidentes.id_accidente%TYPE
) RETURN BOOLEAN IS
    v_accid   BOOLEAN;
    num_accid NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO num_accid
    FROM
        s_tipos_accidentes
    WHERE
        id_accidente = upper(idpacien);

    IF num_accid > 0 THEN
        v_accid := true;
    ELSE
        v_accid := false;
    END IF;

    RETURN v_accid;
END;
/

DECLARE
    idpacien s_tipos_accidentes.id_accidente%TYPE;
    
BEGIN
    
    IF  hay_accid_tipo('3') THEN
        dbms_output.put_line('Si hay registros');
    ELSE
        dbms_output.put_line('No hay registros');
    END IF;

END;
/
--PARTE 2

CREATE OR REPLACE PROCEDURE total_tipo (
    idpacien IN s_tipos_accidentes.id_accidente%TYPE,
    sumacc   OUT NUMBER
) IS
    v_accid BOOLEAN := false;
BEGIN
    v_accid := hay_accid_tipo(idpacien);
    IF v_accid THEN
        SELECT
            SUM(id_accidente)
        INTO sumacc
        FROM
            s_tipos_accidentes
        WHERE
            id_accidente = upper(idpacien)
        GROUP BY
            id_accidente;

    ELSE
        sumacc := -1;
    END IF;

END;
/

DECLARE
    sumacc NUMBER;
BEGIN
    total_tipo('A2', sumacc);
    dbms_output.put_line(' hay '
                         || sumacc
                         || ' accidentes');
END;
/

--PARTE 3
DECLARE
    v_codigo     v_ventas.cod_zona%TYPE := '&zona';
    total_ventas v_ventas.unidades%TYPE;
BEGIN
    SELECT
        SUM(unidades)
    INTO total_ventas
    FROM
        v_ventas
    WHERE
        cod_zona = upper(v_codigo);

    IF total_ventas = 0 THEN
        dbms_output.put_line('ESA ZONA NO TIENE VENTAS');
    ELSE
        dbms_output.put_line('La zona con codigo '
                             || v_codigo
                             || ' tiene '
                             || total_ventas
                             || ' ventas');
    END IF;

END;
/