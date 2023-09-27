DECLARE
  num NUMBER := &numE;
  factorial NUMBER := 1;
BEGIN
  IF num >= 1 THEN
    FOR i IN 2..num LOOP
      factorial := factorial * i;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('El factorial de ' || num || ' es ' || factorial);
   
  ELSE
  DBMS_OUTPUT.PUT_LINE('El numero no es valido');
  END IF;
END;
/