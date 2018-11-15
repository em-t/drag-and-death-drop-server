--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: fact; Type: TABLE; Schema: public; Owner: oppilas
--

CREATE TABLE public.fact (
    id integer NOT NULL,
    queen_id integer,
    quote text
);


ALTER TABLE public.fact OWNER TO oppilas;

--
-- Name: fact_id_seq; Type: SEQUENCE; Schema: public; Owner: oppilas
--

CREATE SEQUENCE public.fact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fact_id_seq OWNER TO oppilas;

--
-- Name: fact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oppilas
--

ALTER SEQUENCE public.fact_id_seq OWNED BY public.fact.id;


--
-- Name: queen; Type: TABLE; Schema: public; Owner: oppilas
--

CREATE TABLE public.queen (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    image character varying(255)
);


ALTER TABLE public.queen OWNER TO oppilas;

--
-- Name: queen_id_seq; Type: SEQUENCE; Schema: public; Owner: oppilas
--

CREATE SEQUENCE public.queen_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.queen_id_seq OWNER TO oppilas;

--
-- Name: queen_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oppilas
--

ALTER SEQUENCE public.queen_id_seq OWNED BY public.queen.id;


--
-- Name: fact id; Type: DEFAULT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.fact ALTER COLUMN id SET DEFAULT nextval('public.fact_id_seq'::regclass);


--
-- Name: queen id; Type: DEFAULT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.queen ALTER COLUMN id SET DEFAULT nextval('public.queen_id_seq'::regclass);


--
-- Data for Name: fact; Type: TABLE DATA; Schema: public; Owner: oppilas
--

COPY public.fact (id, queen_id, quote) FROM stdin;
1	8	"HIEEEEE!"
2	8	Your makeup is TERRIBLE!"
3	8	"Anus-thing is possible."
4	8	"My name is yours... What's Alaska?"
5	8	"If you're not wearing nails, you're not doing drag."
6	8	has an album called 'Anus'
7	4	"Jesus is a biscuit! Let him sop you up!"
8	4	"Get those nuts away from my face!"
9	4	"Let me explain to you what a bitch is: Being In Total Control of Herself."
10	4	"She is large and in charge, chunky, yet funky. Bold and Beautiful baby."
11	4	played a character named "Terry" in the movie "Cherry Pop", making her the only Ru-Girl to perform a non-Drag Queen character
12	22	performs drag with aerial silks
13	22	the first queen to have released their own paper doll book
14	22	"I am a one-of-a-kind collectible."
15	21	"I like my men like I like my coffee...incapable of loving me back"
16	21	"Snatching trophies? (laughs) I am a trophy."
\.


--
-- Data for Name: queen; Type: TABLE DATA; Schema: public; Owner: oppilas
--

COPY public.queen (id, name, image) FROM stdin;
1	RuPaul	""
2	Shangela	""
3	Chad Michaels	""
4	Latrice Royale	""
5	Willam	""
6	Jiggly Caliente	""
7	Sharon Needles	""
8	Alaska	""
9	Roxxxy Andrews	""
10	Jinkx Monsoon	""
11	Alyssa Edwards	""
12	Detox	""
13	Adore Delano	""
14	BenDeLaCreme	""
15	Bianca Del Rio	""
16	Courtney Act	""
17	Milk	""
18	Gia Gunn	""
19	Ginger Minj	""
20	Katya	""
21	Trixie Mattel	""
22	Violet Chachki	""
23	Pearl	""
24	Jasmine Masters	""
25	Miss Fame	""
26	Acid Betty	""
27	Bob The Drag Queen	""
28	Chi Chi DeVayne	""
29	Derrick Barry	""
30	Kim Chi	""
31	Naomi Smalls	""
32	Acid Betty	""
33	Thorgy Thor	""
34	Cynthia Lee Fontaine	""
35	Aja	""
36	Eureka O'Hara	""
37	Farrah Moan	""
38	Peppermint	""
39	Sasha Velour	""
40	Shea Couleé	""
41	Trinity Tailor	""
42	Valentina	""
43	Nina Bo'nina Brown	""
44	Aquaria	""
45	Asia O'Hara	""
46	Blair St. Clair	""
47	Kameron Michaels	""
48	Miz Cracker	""
49	Monét X Change	""
50	Monique Heart	""
51	The Vixen	""
\.


--
-- Name: fact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oppilas
--

SELECT pg_catalog.setval('public.fact_id_seq', 16, true);


--
-- Name: queen_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oppilas
--

SELECT pg_catalog.setval('public.queen_id_seq', 51, true);


--
-- Name: fact fact_pkey; Type: CONSTRAINT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.fact
    ADD CONSTRAINT fact_pkey PRIMARY KEY (id);


--
-- Name: queen queen_pkey; Type: CONSTRAINT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.queen
    ADD CONSTRAINT queen_pkey PRIMARY KEY (id);


--
-- Name: fact fact_queen_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: oppilas
--

ALTER TABLE ONLY public.fact
    ADD CONSTRAINT fact_queen_id_fkey FOREIGN KEY (queen_id) REFERENCES public.queen(id);


--
-- PostgreSQL database dump complete
--

