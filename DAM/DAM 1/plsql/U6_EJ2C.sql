CREATE OR REPLACE FUNCTION contarproductosrangoprecios3 (
    vMin IN NUMBER,
    vMax IN NUMBER
) RETURN NUMBER IS
    v_cont NUMBER := 0;
    CURSOR c2 IS
    SELECT
        precio
    FROM
        producto;
BEGIN 
 IF vMax > vMin THEN
    FOR cemp IN c2 LOOP
        IF
            cemp.precio >= vMin
            AND cemp.precio <= vMax
        THEN
            v_cont := v_cont + 1;
    END IF;
END LOOP;
    ELSE
    v_cont:=-1;
  END IF; 
  RETURN v_cont;
END;
/
DECLARE
  cont NUMBER;
BEGIN
  cont := ContarProductosRangoPrecios3(20, 15); -- Llamada a la función con los valores 1 y 2
  DBMS_OUTPUT.PUT_LINE(cont);
END;
/