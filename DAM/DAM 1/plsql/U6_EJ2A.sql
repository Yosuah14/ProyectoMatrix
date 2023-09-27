CREATE OR REPLACE FUNCTION ContarProductosRangoPrecios(vMin in NUMBER, vMax in NUMBER) RETURN NUMBER IS
  v_cont NUMBER:=0 ;
  CURSOR c2 IS SELECT precio FROM Producto;
  cemp c2%ROWTYPE;
BEGIN
OPEN c2;
  IF vMax > vMin THEN
    
    IF c2%NOTFOUND THEN
      v_cont := -1;
    END IF;

    FETCH c2 INTO cemp;
    WHILE c2%FOUND LOOP
      IF cemp.precio >= vMin AND cemp.precio <= vMax THEN
        v_cont := v_cont + 1;
      END IF;
      FETCH c2 INTO cemp;
    END LOOP;
    CLOSE c2;
  END IF;
  RETURN v_cont;
END;
/
DECLARE
  cont NUMBER;
BEGIN
  cont := ContarProductosRangoPrecios(1, 2); -- Llamada a la función con los valores 1 y 2
  DBMS_OUTPUT.PUT_LINE(cont);
END;
/

