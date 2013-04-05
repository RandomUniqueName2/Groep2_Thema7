    IF l_errors IS NOT NULL
    THEN
        RAISE_APPLICATION_ERROR(-20800, l_errors);
    END IF;
END;