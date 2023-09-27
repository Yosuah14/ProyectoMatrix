CREATE OR REPLACE FUNCTION existeclientebyld (
    v_id NUMBER
) RETURN BOOLEAN IS
    auxiliar NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO auxiliar
    FROM
        cliente c
    WHERE
        c.codigo_cliente = v_id;

    IF auxiliar > 0 THEN
        RETURN true;
    ELSE
        RETURN false;
    END IF;
END;
/

CREATE OR REPLACE FUNCTION existeclientebyname (
    v_nombre cliente.nombre_cliente%TYPE
) RETURN BOOLEAN IS
    num_cliente NUMBER;
BEGIN
    if v_nombre is null or (length(trim(v_nombre))=0) then
        return false;
    end if;
    SELECT
        codigo_cliente
    INTO num_cliente
    FROM
        cliente
    WHERE
        upper(nombre_cliente) LIKE upper('%'||v_nombre||'%');  
        return true;
END;
/

DECLARE
    v_boolean BOOLEAN;
BEGIN
    v_boolean := existeclientebyld(452345);
    if v_boolean then dbms_output.put_line('existe');else dbms_output.put_line('no existe'); end if;
END;
/




DECLARE
    v_boolean BOOLEAN;
BEGIN
    v_boolean := existeclientebyname('Josete maquina');
    if v_boolean then dbms_output.put_line('existe');else dbms_output.put_line('no existe'); end if;
END;
/
