import AboutList from "../Lists/AboutList";

const About = () => {
  const DUMMY_DATA = [
    {
      id: "m1",
      name: "Brian Mgbokwere",
      image: "ReactAndViteFrontend/src/components/photos/Brian.jpg",
      biography:
        "I am a graduate from Northern Illinois University, where I earned my Bachelor of Science in Health Sciences. My studies focused on environmental health, physical and mental health, and how to best deliver care to under-served communities. Despite my background, I have always had an interest in software development.",
    },

  ];

  return (
    <section>
      <h1>About</h1>
      {/* <ul>
        <AboutList bios={DUMMY_DATA} />
      </ul> */}
    </section>
  );
};

export default About;
