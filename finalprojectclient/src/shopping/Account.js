import { Margin } from "@mui/icons-material";
import { Box, Avatar, Typography } from "@mui/material";
import { useAuth } from "../context/AuthContext";

export default function Account() {
    const {getUser}=useAuth();
    const email=getUser().data.email;
    const user = {
    email: email,
    imageUrl:
      "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=200",
  };

  return (
    <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", marginTop:25}}>
      <Avatar
        alt="User Avatar"
        src={user.imageUrl}
        sx={{ width: 128, height: 128, mb: 2 }}
      />
      <Box
        sx={{
          bgcolor: "background.paper",
          boxShadow: 1,
          borderRadius: 1,
          p: 2,
          minWidth: 300,
        }}
      >
        <Typography variant="h6" component="h2" gutterBottom>
          {user.email}
        </Typography>
      </Box>
    </Box>
  );
}