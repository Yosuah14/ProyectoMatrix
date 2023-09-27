CREATE OR REPLACE FUNCTION ContarProductosRangoPrecios2(vMin IN NUMBER, vMax IN NUMBER) RETURN NUMBER IS
  v_cont NUMBER := 0;
  CURSOR c2 IS SELECT precio FROM Producto;
  cemp c2%ROWTYPE;
BEGIN
  OPEN c2;
  IF vMax > vMin THEN
    IF c2%NOTFOUND THEN
      v_cont := -1;
    ELSE
      LOOP
        FETCH c2 INTO cemp;
        EXIT WHEN c2%NOTFOUND;
        
        IF cemp.precio >= vMin AND cemp.precio <= vMax THEN
          v_cont := v_cont + 1;
        END IF;
      END LOOP;
    END IF;
  END IF;
  
  CLOSE c2;
  RETURN v_cont;
END;
/

DECLARE
  cont NUMBER;
BEGIN
  cont := ContarProductosRangoPrecios2(2, 14); -- Llamada a la función con los valores 1 y 2
  DBMS_OUTPUT.PUT_LINE(cont);
END;
/


