CREATE OR REPLACE FUNCTION translate_fr(pn$nombre_en in varchar2) 
RETURN VARCHAR2 
AS 
BEGIN 
    RETURN REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( REPLACE( 
           REPLACE( REPLACE( REPLACE( REPLACE( 
                                                pn$nombre_en 
                                              , 'million'           , 'millions'        ) 
                                              , 'billion'           , 'milliards'       ) 
                                           , 'trillion'          , 'trillions'       ) 
                                           , 'quadrillion'       , 'quadrillions'    ) 
                                              , 'quintillion'       , 'cintillions'     ) 
                                           , 'sextillion'        , 'sextillions'     )    
                                           , 'septillion'        , 'septillions'     )  
                                           , 'octillion'         , 'octillions'      ) 
                                           , 'nonillion'         , 'nonillions'      )  
                                           , 'decillion'         , 'decillions'      )  
                                           , 'undecillion'       , 'undecillions'    )  
                                           , 'duodecillion'      , 'duodecillions'   )  
                                           , 'tridecillion'      , 'tridecillions'   )  
                                           , 'quaddecillion'     , 'quaddecillions'  )  
                                           , 'quindecillion'     , 'quindecillions'  )  
                                           , 'sexdecillion'      , 'sexdecillions'   )  
                                           , 'septdecillion'     , 'septdecillions'  )  
                                           , 'octdecillion'      , 'octdecillions'   )  
                                           , 'nondecillion'      , 'nondecillions'   )  
                                           , 'dedecillion'       , 'dedecillions'    )  
                                              , 'thousand'          , 'mille'           ) 
                                              , 'hundred'           , 'cent'            ) 
                                              , 'ninety'            , 'quatre-vingt-dix') 
                                              , 'eighty'            , 'quatre-vingts'   ) 
                                              , 'seventy'           , 'soixante-dix'    ) 
                                              , 'sixty'             , 'soixante'        ) 
                                              , 'fifty'             , 'cinquante'       ) 
                                              , 'forty'             , 'quarante'        ) 
                                              , 'thirty'            , 'trente'          ) 
                                              , 'twenty'            , 'vingt'           ) 
                                              , 'nineteen'          , 'dix-neuf'        ) 
                                              , 'eighteen'          , 'dix-huit'        ) 
                                              , 'seventeen'         , 'dix-sept'        ) 
                                              , 'sixteen'           , 'seize'           ) 
                                              , 'fifteen'           , 'quinze'          ) 
                                              , 'fourteen'          , 'quatorze'        ) 
                                              , 'thirteen'          , 'treize'          ) 
                                              , 'twelve'            , 'douze'           ) 
                                              , 'eleven'            , 'onze'            ) 
                                              , 'ten'               , 'dix'             ) 
                                              , 'nine'              , 'neuf'            ) 
                                              , 'eight'             , 'huit'            ) 
                                              , 'seven'             , 'sept'            ) 
                                              , 'five'              , 'cinq'            ) 
                                              , 'four'              , 'quatre'          ) 
                                              , 'three'             , 'trois'           ) 
                                              , 'two'               , 'deux'            ) 
                                              , 'one'               , 'un'              ) 
                                              , 'dix-six'           , 'seize'           ) 
                                              , 'dix-cinq'          , 'quinze'          ) 
                                              , 'dix-quatre'        , 'quatorze'        ) 
                                              , 'dix-trois'         , 'treize'          ) 
                                              , 'dix-deux'          , 'douze'           ) 
                                              , 'dix-un'            , 'onze'            ) 
                                              , '-un '              , '-une '           ) 
                                              , 'un cent'           , 'cent'            ) 
                                              , 'un mille'          , 'mille'           ) 
                                              , 'une'               , 'un'              ) 
                                              , 'soixante-onze'     , 'soixante et onze') 
                                              , 'quatre-vingts-'    , 'quatre-vingt-'   ) 
                                              , '-un'               , ' et un'          ) 
                                              , 'quatre-vingt et un', 'quatre-vingt-un' ) 
                                              , 'deux cent'         , 'deux cents'      ) 
                                              , 'trois cent'        , 'trois cents'     ) 
                                              , 'quatre cent'       , 'quatre cents'    ) 
                                              , 'cinq cent'         , 'cinq cents'      ) 
                                              , 'six cent'          , 'six cents'       ) 
                                              , 'sept cent'         , 'sept cents'      ) 
                                              , 'huit cent'         , 'huit cents'      ) 
                                              , 'neuf cent'         , 'neuf cents'      ) 
                                              , 'cents '            , 'cent '           ) 
                                              , 'un millions'       , 'un million'      ) 
                                              , 'un bidecillions'   , 'un bidecillion'  ) 
                                              , 'un cintillions'    , 'un cintillion'   ) 
                                              , 'un milliards'      , 'un milliard'     ) 
                                           , 'un trillions'      , 'un trillion'      ) 
                                           , 'un quadrillions'   , 'un quadrillion'   ) 
                                           , 'un sextillions'    , 'un sextillion'    )    
                                           , 'un septillions'    , 'un septillion'    )  
                                           , 'un octillions'     , 'un octillion'     ) 
                                           , 'un nonillions'     , 'un nonillion'     )  
                                           , 'un decillions'     , 'un decillion'     )  
                                           , 'un undecillions'   , 'un undecillion'   )  
                                   , 'un duodecillions'  , 'un duodecillion'  )  
                                           , 'un tridecillions'  , 'un tridecillion'  )  
                                           , 'un quaddecillions' , 'un quaddecillion' )  
                                           , 'un quindecillions' , 'un quindecillion' )  
                                           , 'un sexdecillions'  , 'un sexdecillion'  )  
                                           , 'un septdecillions' , 'un septdecillion' )  
                                           , 'un octdecillions'  , 'un octdecillion'  )  
                                           , 'un nondecillions'  , 'un nondecillion'  )  
                                           , 'un dedecillions'   , 'un dedecillion'   )  
                                           , '-un trillion'      , '-un trillions'     ) 
                                           , '-un quadrillion'   , '-un quadrillions'  ) 
                                           , '-un sextillion'    , '-un sextillions'   )    
                                           , '-un septillion'    , '-un septillions'   )  
                                           , '-un octillion'     , '-un octillions'    ) 
                                           , '-un nonillion'     , '-un nonillions'    )  
                                           , '-un decillion'     , '-un decillions'    )  
                                           , '-un undecillion'   , '-un undecillions'  )  
                                           , '-un duodecillion'  , '-un duodecillions' )  
                                           , '-un tridecillion'  , '-un tridecillions' )  
                                           , '-un quaddecillion' , '-un quaddecillions')  
                                           , '-un quindecillion' , '-un quindecillions')  
                                           , '-un sexdecillion'  , '-un sexdecillions' )  
                                           , '-un septdecillion' , '-un septdecillions')  
                                           , '-un octdecillion'  , '-un octdecillions' )  
                                           , '-un nondecillion'  , '-un nondecillions' )  
                                           , '-un dedecillion'   , '-un dedecillions'  )  
                                              , '-un million'       , '-un millions'    ) 
                                              , '-un bidecillion'   , '-un bidecillions') 
                                              , '-un cintillion'    , '-un cintillions' ) 
                                              , '-un milliard'      , '-un milliards'   ) 
                                              , 'point'             , 'virgule'         ) 
                          ; 
END translate_fr; 
/