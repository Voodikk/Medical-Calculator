--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-08-09 08:54:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 25065)
-- Name: regions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.regions (
    region_id integer NOT NULL,
    region_number integer,
    vote_id integer
);


ALTER TABLE public.regions OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 25064)
-- Name: regions_region_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.regions_region_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.regions_region_id_seq OWNER TO postgres;

--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 214
-- Name: regions_region_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.regions_region_id_seq OWNED BY public.regions.region_id;


--
-- TOC entry 217 (class 1259 OID 25072)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 25071)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 216
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 219 (class 1259 OID 25079)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    username character varying(255),
    region_id integer
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 25087)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
    user_id bigint NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 25078)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 3391 (class 0 OID 0)
-- Dependencies: 218
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 222 (class 1259 OID 25091)
-- Name: votes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.votes (
    id bigint NOT NULL,
    points integer,
    region_id integer,
    user_id bigint
);


ALTER TABLE public.votes OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 25098)
-- Name: votes_avg; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.votes_avg (
    id integer NOT NULL,
    v_avg real,
    region_id integer
);


ALTER TABLE public.votes_avg OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 25097)
-- Name: votes_avg_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.votes_avg_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.votes_avg_id_seq OWNER TO postgres;

--
-- TOC entry 3392 (class 0 OID 0)
-- Dependencies: 223
-- Name: votes_avg_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.votes_avg_id_seq OWNED BY public.votes_avg.id;


--
-- TOC entry 221 (class 1259 OID 25090)
-- Name: votes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.votes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.votes_id_seq OWNER TO postgres;

--
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 221
-- Name: votes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.votes_id_seq OWNED BY public.votes.id;


--
-- TOC entry 3197 (class 2604 OID 25068)
-- Name: regions region_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.regions ALTER COLUMN region_id SET DEFAULT nextval('public.regions_region_id_seq'::regclass);


--
-- TOC entry 3198 (class 2604 OID 25075)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 3199 (class 2604 OID 25082)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 3200 (class 2604 OID 25094)
-- Name: votes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes ALTER COLUMN id SET DEFAULT nextval('public.votes_id_seq'::regclass);


--
-- TOC entry 3201 (class 2604 OID 25101)
-- Name: votes_avg id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes_avg ALTER COLUMN id SET DEFAULT nextval('public.votes_avg_id_seq'::regclass);


--
-- TOC entry 3374 (class 0 OID 25065)
-- Dependencies: 215
-- Data for Name: regions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.regions (region_id, region_number, vote_id) FROM stdin;
1	30	\N
2	22	\N
3	28	\N
4	29	\N
5	31	\N
6	32	\N
7	33	\N
8	34	\N
9	35	\N
10	36	\N
11	77	\N
12	78	\N
13	92	\N
14	93	\N
15	79	\N
16	75	\N
17	90	\N
18	37	\N
19	99	\N
20	38	\N
21	7	\N
22	39	\N
23	40	\N
24	41	\N
25	9	\N
26	42	\N
27	43	\N
28	44	\N
29	23	\N
30	24	\N
31	45	\N
32	46	\N
33	47	\N
34	48	\N
35	94	\N
36	49	\N
37	50	\N
38	51	\N
39	83	\N
40	52	\N
41	53	\N
42	54	\N
43	55	\N
44	56	\N
45	57	\N
46	58	\N
47	59	\N
48	25	\N
49	60	\N
50	1	\N
51	4	\N
52	2	\N
53	3	\N
54	5	\N
55	6	\N
56	8	\N
57	10	\N
58	11	\N
59	91	\N
60	12	\N
61	13	\N
62	14	\N
63	15	\N
64	16	\N
65	17	\N
66	19	\N
67	61	\N
68	62	\N
69	63	\N
70	64	\N
71	65	\N
72	66	\N
73	67	\N
74	26	\N
75	68	\N
76	69	\N
77	70	\N
78	71	\N
79	72	\N
80	18	\N
81	73	\N
82	27	\N
83	86	\N
84	95	\N
85	74	\N
86	20	\N
87	21	\N
88	87	\N
89	89	\N
90	76	\N
\.


--
-- TOC entry 3376 (class 0 OID 25072)
-- Dependencies: 217
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
2	ROLE_ADMIN
1	ROLE_USER
\.


--
-- TOC entry 3378 (class 0 OID 25079)
-- Dependencies: 219
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, email, password, username, region_id) FROM stdin;
5	u@mail.ru	$2a$10$wOkcD1lNKew8QBs7k4PA8.1yrWr0EhRCjsA/F6ykVLF0DVLnfUM2S	user1	1
6	info1@mail.ru	$2a$10$jX.OJdFql0hnyHGq2TeqKOVEwgzST.6fjMEgMzj4T8yToZSLhh1gC	user	1
7	lipatnio@yandex.ru	$2a$10$RSkMW01.MeihBo4jHIs/KOqytfMf6ENrcpGeJLw/0HJZzs80D0T/.	wer	10
8	user1.1@mail.ru	$2a$10$W1YxJUEJ1QJb.MC1I/5Hme5rDlA.2P53IvZAwiQdXAvlWZQjrzYbu	user1.1	7
9	user1.2@mail.ru	$2a$10$MNREjPsJoilDl2DW276BjOysJFo7.vbJPUt3xmWDgevvvmaPi7b3C	user1.2	7
10	2@mail.ru	$2a$10$Gk8TDJMBEUiR5xjv3y4gfOaCA1Abl372Kp0dtNhuE4Svff7QfTWeG	user2.1	16
12	1@mail.ru	$2a$10$ZMSvosIT6hyeGCeK0q2.kufCqiLpcxcUJTDV9/b43E263sP9LCkL2	user2.2	24
13	3@mail.ru	$2a$10$Fdxf.YbkdB8lZP5ZJugSdumFDnRxLbXnc7Oq/AJo.8caCjPTNv.im	user2.3	11
14	4@mail.ru	$2a$10$LzS22Wh7.DKqrg5DhGXY8uykVBiSuuPH2tTAk/bNjIT1wyF2P0CzW	user2.4	5
15	5@mail.ru	$2a$10$.0whLJKGHqgpT8nMcV4aYuveNNPUtA/DO8cMvV4z0rEL.s0M.JtEe	user2.5	9
16	6@mail.ru	$2a$10$BrAUp0LZrOfTdVLoy9LWvOj7b7S9hWslIkZoDXUfmAZqbiYoUA4fi	user2.6	10
17	7@mail.ru	$2a$10$0OXR4O.yhFuy7zq2axHL0epbWqvxZhSN9WVLSUiVZueJyVdkkxN.q	user2.7	15
18	8@mail.ru	$2a$10$cDzYJ4.GG8msuhFedSXd.ugdBPQ5spLY95Ww1WraEIj0I9l5g/V3e	user2.8	10
20	3.0@mail.ru	$2a$10$khcz59xNsLG4ZNkgF3L6/eQACURZtLm0DSLegAhFFstzp6UxOZCQq	user3.0	21
21	3.1@mail.ru	$2a$10$o1Lhgd3yQZWL4fGtOwbJ1uoSRrtFaTmGMq.3K3/TLjc0Z.HQioZtW	user3.1	18
22	3.2@mail.ru	$2a$10$kUoTmUi4q727SzSXtFm4Wetudd884WFFPaijTNsms2uh.YgVOUfWu	user3.2	2
23	3.3@mail.ru	$2a$10$IX.p8.Hp7s9A2nJRbtwTKeVdhoFinx4qrFd6QdQtidzuM11YV6KuO	user3.3	22
24	3.4@mail.ru	$2a$10$uayFuqGJ0OVpltlr3NZkCuzwi.wGtYfDTJNlvdV8Rw/N4Rf2AO2.m	user3.4	8
25	4.1@mail.ru	$2a$10$a.DT2xhQOCopSwpNEZS9muYeGzmIT7mkAa0dAsSZrinz4xKJrwMAy	user4.1	2
27	4.2@mail.ru	$2a$10$5hwl2T4hSteniiZdauwev.72GV7CgPvZqsbDXYx7RvSalX1jYkLb6	user4.2	2
28	4.3@mail.ru	$2a$10$lPndkarW8jQtsUReVyEPYOSiadDB8NBW3MDBVVRzTZr.X3peJGf/m	user4.3	70
29	4.4@mail.ru	$2a$10$M/aCaI9fY89uEY88uRdQ0O2ew3I9k3GC01DW0QIL41wbJVV7tv6MO	user4.4	62
\.


--
-- TOC entry 3379 (class 0 OID 25087)
-- Dependencies: 220
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (user_id, role_id) FROM stdin;
5	1
6	1
7	1
8	1
9	1
10	1
12	1
13	1
14	1
15	1
16	1
17	1
18	1
20	1
21	1
22	1
23	1
24	1
25	1
27	1
28	1
29	1
\.


--
-- TOC entry 3381 (class 0 OID 25091)
-- Dependencies: 222
-- Data for Name: votes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.votes (id, points, region_id, user_id) FROM stdin;
4	4	1	5
5	9	1	6
6	7	10	7
9	1	7	9
8	4	7	8
11	9	16	10
13	7	5	14
14	7	70	28
12	3	24	12
15	4	62	29
\.


--
-- TOC entry 3383 (class 0 OID 25098)
-- Dependencies: 224
-- Data for Name: votes_avg; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.votes_avg (id, v_avg, region_id) FROM stdin;
22	1	2
23	2	3
24	3	4
26	5	6
27	6	11
28	7	8
29	8	9
30	9	12
31	5.5	13
32	5	14
33	3	15
35	2	17
36	10	18
37	8.4	19
38	6	20
39	6.2	21
40	8.1	22
41	7.6	23
43	1	25
44	3	26
45	5	27
46	7	28
47	8	29
48	9	30
49	9	31
50	1	32
51	9	33
52	5	34
53	6	35
54	7	36
55	3	37
56	2	38
57	6	39
58	7	40
59	1	41
60	3	42
61	3	43
62	4	44
63	5	45
64	5	46
65	4	47
66	6	48
67	6	49
68	6	50
69	5	51
70	5	52
71	8	53
72	6	54
73	8	55
74	8	56
75	7.5	57
76	8	58
77	6.1	59
78	8	60
79	9	61
81	8	63
82	8	64
83	5.7	65
84	8	66
85	5.1	67
86	9	68
87	4	69
89	5	71
90	9	72
91	8	73
92	9	74
93	8	75
94	4	76
95	10	77
96	8	78
97	6	79
98	4	80
88	7	70
25	7	5
20	2.5	7
19	7	10
34	9	16
21	6.5	1
42	3	24
80	4	62
\.


--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 214
-- Name: regions_region_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.regions_region_id_seq', 90, true);


--
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 216
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 1, false);


--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 218
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 29, true);


--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 223
-- Name: votes_avg_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.votes_avg_id_seq', 178, true);


--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 221
-- Name: votes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.votes_id_seq', 15, true);


--
-- TOC entry 3203 (class 2606 OID 25070)
-- Name: regions regions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.regions
    ADD CONSTRAINT regions_pkey PRIMARY KEY (region_id);


--
-- TOC entry 3209 (class 2606 OID 25077)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3211 (class 2606 OID 25107)
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 3205 (class 2606 OID 25105)
-- Name: regions uk_9bce2is0gg3qcyc6r23xu9uyt; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.regions
    ADD CONSTRAINT uk_9bce2is0gg3qcyc6r23xu9uyt UNIQUE (region_number);


--
-- TOC entry 3207 (class 2606 OID 25160)
-- Name: regions uk_hfmsfcybyum8wr0tsg6g6dxyi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.regions
    ADD CONSTRAINT uk_hfmsfcybyum8wr0tsg6g6dxyi UNIQUE (vote_id);


--
-- TOC entry 3221 (class 2606 OID 25113)
-- Name: votes_avg uk_irtinkm28xe85sjsoedhlthc2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes_avg
    ADD CONSTRAINT uk_irtinkm28xe85sjsoedhlthc2 UNIQUE (region_id);


--
-- TOC entry 3217 (class 2606 OID 25111)
-- Name: votes uk_jpy5cpqhdr870g41de432t0kp; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT uk_jpy5cpqhdr870g41de432t0kp UNIQUE (user_id);


--
-- TOC entry 3213 (class 2606 OID 25109)
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- TOC entry 3215 (class 2606 OID 25086)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3223 (class 2606 OID 25103)
-- Name: votes_avg votes_avg_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes_avg
    ADD CONSTRAINT votes_avg_pkey PRIMARY KEY (id);


--
-- TOC entry 3219 (class 2606 OID 25096)
-- Name: votes votes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT votes_pkey PRIMARY KEY (id);


--
-- TOC entry 3224 (class 2606 OID 25161)
-- Name: regions fk2gk57jjj2xeimmel323ryul15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.regions
    ADD CONSTRAINT fk2gk57jjj2xeimmel323ryul15 FOREIGN KEY (vote_id) REFERENCES public.votes_avg(id);


--
-- TOC entry 3226 (class 2606 OID 25124)
-- Name: users_roles fk2o0jvgh89lemvvo17cbqvdxaa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 3225 (class 2606 OID 25114)
-- Name: users fk4muym4ujsr1xfh4qc3wsmmrhe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk4muym4ujsr1xfh4qc3wsmmrhe FOREIGN KEY (region_id) REFERENCES public.regions(region_id);


--
-- TOC entry 3227 (class 2606 OID 25119)
-- Name: users_roles fkj6m8fwv7oqv74fcehir1a9ffy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkj6m8fwv7oqv74fcehir1a9ffy FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 3228 (class 2606 OID 25134)
-- Name: votes fkli4uj3ic2vypf5pialchj925e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT fkli4uj3ic2vypf5pialchj925e FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 3229 (class 2606 OID 25129)
-- Name: votes fknfpn8g15u1u3ifsp40spt56nm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT fknfpn8g15u1u3ifsp40spt56nm FOREIGN KEY (region_id) REFERENCES public.regions(region_id);


--
-- TOC entry 3230 (class 2606 OID 25139)
-- Name: votes_avg fkrnk0ubgkqdpl0eh50gu8g4nap; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.votes_avg
    ADD CONSTRAINT fkrnk0ubgkqdpl0eh50gu8g4nap FOREIGN KEY (region_id) REFERENCES public.regions(region_id);


-- Completed on 2023-08-09 08:54:14

--
-- PostgreSQL database dump complete
--

